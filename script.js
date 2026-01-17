const API_BASE_URL = window.location.hostname === 'localhost' || window.location.hostname === '127.0.0.1'
    ? 'http://localhost:8081/api'
    : 'https://bikewaleclone.onrender.com/api';


document.addEventListener('DOMContentLoaded', () => {
    // Check which page we are on
    if (document.getElementById('brandList')) {
        fetchBrands();
        fetchBikes();
    }

    if (document.getElementById('bikeDetails')) {
        const urlParams = new URLSearchParams(window.location.search);
        const bikeId = urlParams.get('id');
        log('Page loaded. BikeID param: ' + bikeId);

        if (bikeId) {
            log('Fetching bike details for ID: ' + bikeId);
            fetchBikeDetails(bikeId);
        } else {
            log('No bike ID found in URL.');
            document.getElementById('bikeName').textContent = 'No bike selected';
            document.getElementById('bikeDetails').innerHTML = '<p>No bike selected. Please go back to home page.</p>';
        }
    }
});

async function fetchBrands() {
    try {
        const response = await fetch(`${API_BASE_URL}/brands`);
        const brands = await response.json();
        const brandList = document.getElementById('brandList');
        brandList.innerHTML = '';

        brands.forEach(brand => {
            const card = document.createElement('div');
            card.className = 'brand-card';
            card.innerHTML = `
                <img src="${brand.logoUrl}" alt="${brand.name}">
                <h3>${brand.name}</h3>
            `;
            // Add click event to filter bikes by brand if needed
            card.onclick = () => filterBikesByBrand(brand.id);
            brandList.appendChild(card);
        });
    } catch (error) {
        console.error('Error fetching brands:', error);
    }
}

async function fetchBikes() {
    try {
        const response = await fetch(`${API_BASE_URL}/bikes`);
        const bikes = await response.json();
        renderBikes(bikes);
    } catch (error) {
        console.error('Error fetching bikes:', error);
    }
}

async function filterBikesByBrand(brandId) {
    try {
        const response = await fetch(`${API_BASE_URL}/bikes?brandId=${brandId}`);
        const bikes = await response.json();
        renderBikes(bikes);
    } catch (error) {
        console.error('Error fetching bikes by brand:', error);
    }
}

async function searchBikes() {
    const query = document.getElementById('searchInput').value;
    if (!query) return fetchBikes();

    try {
        const response = await fetch(`${API_BASE_URL}/search?query=${query}`);
        const bikes = await response.json();
        renderBikes(bikes);
    } catch (error) {
        console.error('Error searching bikes:', error);
    }
}

function renderBikes(bikes) {
    const bikeGrid = document.getElementById('bikeGrid');
    bikeGrid.innerHTML = '';

    if (bikes.length === 0) {
        bikeGrid.innerHTML = '<p>No bikes found.</p>';
        return;
    }

    // Determine backend base URL (strip /api)
    const backendUrl = API_BASE_URL.replace('/api', '');

    bikes.forEach(bike => {
        const card = document.createElement('div');
        card.className = 'bike-card';

        // Handle image URL (if it's relative, prepend backend URL)
        let imgPath = bike.imageUrl || 'https://via.placeholder.com/300';
        if (imgPath.startsWith('/')) {
            imgPath = backendUrl + imgPath;
        }

        card.innerHTML = `
            <img src="${imgPath}" alt="${bike.name}" class="bike-image">
            <div class="bike-info">
                <div class="bike-name">${bike.name}</div>
                <div class="bike-price">₹ ${(bike.priceMin / 100000).toFixed(2)} - ${(bike.priceMax / 100000).toFixed(2)} Lakh</div>
                <a href="bike-details.html?id=${bike.id}" class="btn">View Details</a>
            </div>
        `;
        bikeGrid.appendChild(card);
    });
}

async function fetchBikeDetails(id) {
    try {
        const response = await fetch(`${API_BASE_URL}/bikes/${id}`);
        if (!response.ok) throw new Error('Bike not found');
        const bike = await response.json();
        const backendUrl = API_BASE_URL.replace('/api', '');

        const bikeNameEl = document.getElementById('bikeName');
        const bikeImageEl = document.getElementById('bikeImage');
        const bikePriceEl = document.getElementById('bikePrice');
        const bikeDescEl = document.getElementById('bikeDesc');

        if (bikeNameEl) bikeNameEl.textContent = bike.name;
        if (bikeImageEl) {
            let imgPath = bike.imageUrl || 'https://via.placeholder.com/600';
            if (imgPath.startsWith('/')) {
                imgPath = backendUrl + imgPath;
            }
            bikeImageEl.src = imgPath;
            bikeImageEl.onerror = function () {
                this.src = 'https://via.placeholder.com/600?text=No+Image';
            };
        }
        if (bikePriceEl) {
            const minPrice = bike.priceMin ? (bike.priceMin / 100000).toFixed(2) : 'N/A';
            const maxPrice = bike.priceMax ? (bike.priceMax / 100000).toFixed(2) : 'N/A';
            bikePriceEl.textContent = `₹ ${minPrice} - ${maxPrice} Lakh`;
        }
        if (bikeDescEl) bikeDescEl.textContent = bike.description || 'No description available.';

        // Render specs if available
        const specsList = document.getElementById('specsList');
        if (specsList && bike.specifications) {
            specsList.innerHTML = '';
            bike.specifications.forEach(spec => {
                const li = document.createElement('li');
                li.innerHTML = `<strong>${spec.specKey || 'Feature'}:</strong> ${spec.specValue || ''}`;
                specsList.appendChild(li);
            });
            log('Rendered ' + bike.specifications.length + ' specifications.');
        } else {
            log('No specifications found or specs list element missing.');
        }
    } catch (error) {
        log('ERROR caught: ' + error.message);
        console.error('Error details:', error);
        const container = document.getElementById('bikeDetails');
        if (container) {
            container.innerHTML = `<div style="text-align:center; padding: 2rem;">
                <h2>Error Loading Bike Details</h2>
                <p>${error.message}</p>
                <a href="index.html" class="btn">Go Back</a>
            </div>`;
        }
    }
}

function log(message) {
    console.log(message);
    let logDiv = document.getElementById('debug-log');
    if (!logDiv) {
        logDiv = document.createElement('div');
        logDiv.id = 'debug-log';
        logDiv.style.background = '#f0f0f0';
        logDiv.style.border = '1px solid #ccc';
        logDiv.style.padding = '10px';
        logDiv.style.margin = '10px';
        logDiv.style.color = '#333';
        logDiv.style.fontFamily = 'monospace';
        logDiv.style.maxHeight = '200px';
        logDiv.style.overflow = 'auto';
        document.body.appendChild(logDiv);
    }
    const entry = document.createElement('div');
    entry.textContent = new Date().toLocaleTimeString() + ': ' + message;
    logDiv.appendChild(entry);
}
