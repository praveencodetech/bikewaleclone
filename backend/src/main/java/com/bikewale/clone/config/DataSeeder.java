package com.bikewale.clone.config;

import com.bikewale.clone.model.Bike;
import com.bikewale.clone.model.Brand;
import com.bikewale.clone.model.Specification;
import com.bikewale.clone.repository.BikeRepository;
import com.bikewale.clone.repository.BrandRepository;
import com.bikewale.clone.repository.SpecificationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final BikeRepository bikeRepository;
    private final SpecificationRepository specificationRepository;

    public DataSeeder(BrandRepository brandRepository, BikeRepository bikeRepository, SpecificationRepository specificationRepository) {
        this.brandRepository = brandRepository;
        this.bikeRepository = bikeRepository;
        this.specificationRepository = specificationRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Checking and seeding database...");

        // Seed Brands
        Brand re = createBrandIfNotFound("Royal Enfield", "/images/Royal%20Enfield.jpg");
        Brand yamaha = createBrandIfNotFound("Yamaha", "/images/Yamaha.jpg");
        Brand java = createBrandIfNotFound("Jawa", "/images/Jawa%20logo.jpg");
        Brand ktm = createBrandIfNotFound("KTM", "/images/ktm_racing-logo.jpg");

        // Seed Bikes
        createBikeIfNotFound("Classic 350", re, 193000.0, 225000.0, 
            "/images/Classic%20350.jpg",
            "The Royal Enfield Classic 350 preserves the retro charm with modern reliability.",
            Arrays.asList(
                new SpecData("Engine", "349 cc"),
                new SpecData("Power", "20.2 bhp"),
                new SpecData("Mileage", "35 kmpl")
            ));

        createBikeIfNotFound("MT 15 V2", yamaha, 168000.0, 174000.0,
            "/images/MT%2015%20V2.jpg",
            "The Yamaha MT-15 V2 is a pure street fighter with agile handling.",
            Arrays.asList(
                new SpecData("Engine", "155 cc"),
                new SpecData("Power", "18.1 bhp"),
                new SpecData("Mileage", "48 kmpl")
            ));

        createBikeIfNotFound("Jawa 42", java, 189000.0, 198000.0,
            "/images/Jawa%2042.jpg",
            "The Jawa 42 adds a modern touch to the classic Jawa design.",
             Arrays.asList(
                new SpecData("Engine", "293 cc"),
                new SpecData("Power", "27 bhp"),
                new SpecData("Mileage", "37 kmpl")
            ));

        // NEW BIKES
        createBikeIfNotFound("Duke 390", ktm, 311000.0, 320000.0,
            "/images/Duke%20390.jpg",
            "The KTM 390 Duke is a corner rocket, combining maximum riding pleasure with optimum spread for user value.",
            Arrays.asList(
                new SpecData("Engine", "373 cc"),
                new SpecData("Power", "42.9 bhp"),
                new SpecData("Mileage", "29 kmpl"),
                new SpecData("Gears", "6 Speed")
            ));
            
        createBikeIfNotFound("R15 V4", yamaha, 181000.0, 196000.0,
            "/images/R15%20V4.jpg",
            "The R15 V4 is a track-focused machine with race-derived aerodynamics and tech.",
            Arrays.asList(
                new SpecData("Engine", "155 cc"),
                new SpecData("Power", "18.4 bhp"),
                new SpecData("Mileage", "45 kmpl")
            ));

        // MORE BIKES
        Brand tvs = createBrandIfNotFound("TVS", "/images/TVS%20motorcycle.jpg");
        Brand bajaj = createBrandIfNotFound("Bajaj", "/images/Bajaj.jpg");

        createBikeIfNotFound("Hunter 350", re, 149900.0, 174000.0,
            "/images/Hunter%20350.jpg",
            "The Royal Enfield Hunter 350 is a modern-retro roadster designed for urban riding.",
            Arrays.asList(
                new SpecData("Engine", "349 cc"),
                new SpecData("Power", "20.2 bhp"),
                new SpecData("Mileage", "36 kmpl"),
                 new SpecData("Weight", "181 kg")
            ));

        createBikeIfNotFound("Apache RR 310", tvs, 272000.0, 280000.0,
            "/images/Apache%20RR%20310.jpg",
            "The TVS Apache RR 310 is a premium sportbike with racing DNA and advanced tech.",
            Arrays.asList(
                new SpecData("Engine", "312.2 cc"),
                new SpecData("Power", "33.5 bhp"),
                new SpecData("Mileage", "33 kmpl"),
                new SpecData("Modes", "Track, Sport, Urban, Rain")
            ));

        createBikeIfNotFound("Pulsar NS200", bajaj, 142000.0, 155000.0,
            "/images/Pulsar%20NS200.jpg",
            "The Bajaj Pulsar NS200 is a naked streetfighter known for its aggressive styling and performance.",
            Arrays.asList(
                new SpecData("Engine", "199.5 cc"),
                new SpecData("Power", "24.1 bhp"),
                new SpecData("Mileage", "36 kmpl")
            ));

        // --- NEW REQUESTED BIKES ---
        Brand triumph = createBrandIfNotFound("Triumph", "/images/Triumph.jpg");
        Brand yezdi = createBrandIfNotFound("Yezdi", "/images/Yezdi.jpg");

        // Royal Enfield Extensions
        createBikeIfNotFound("Continental GT 650", re, 319000.0, 345000.0,
            "/images/Continental%20GT%20650.jpg",
            "The Continental GT 650 is a cafe racer with a powerful twin-cylinder engine.",
            Arrays.asList(new SpecData("Engine", "648 cc"), new SpecData("Power", "47 bhp")));
            
        createBikeIfNotFound("Guerrilla 450", re, 239000.0, 254000.0,
            "/images/Guerrilla%20450.jpg",
            "A modern roadster based on the Sherpa 450 platform.",
            Arrays.asList(new SpecData("Engine", "452 cc"), new SpecData("Power", "39.5 bhp")));

        createBikeIfNotFound("Himalayan 450", re, 285000.0, 298000.0,
            "/images/Himalayan%20450.jpg",
            "The all-new Himalayan 450 is built for all roads and no roads.",
            Arrays.asList(new SpecData("Engine", "452 cc"), new SpecData("Power", "39.5 bhp")));
            
        createBikeIfNotFound("Shotgun 650", re, 359000.0, 373000.0,
            "/images/Shotgun%20650.jpg",
            "A custom-inspired bobber on the 650 twin platform.",
            Arrays.asList(new SpecData("Engine", "648 cc"), new SpecData("Power", "46.3 bhp")));

        createBikeIfNotFound("Bear 650", re, 339000.0, 359000.0,
             "/images/Bear%20650.jpg",
             "A scrambler style motorcycle based on the Interceptor 650.",
             Arrays.asList(new SpecData("Engine", "648 cc"), new SpecData("Power", "47 bhp")));

        // Triumph
        createBikeIfNotFound("Speed 400", triumph, 224000.0, 234000.0,
            "/images/Speed%20400.jpg",
            "Iconic Triumph style, character and quality, accessibly priced.",
            Arrays.asList(new SpecData("Engine", "398.15 cc"), new SpecData("Power", "39.5 bhp")));

        createBikeIfNotFound("Scrambler 400X", triumph, 254000.0, 264000.0,
            "/images/Scrambler%20400X.jpg",
            "Built for all riders, and all terrains.",
            Arrays.asList(new SpecData("Engine", "398.15 cc"), new SpecData("Power", "39.5 bhp")));

        createBikeIfNotFound("Thruxton 400", triumph, 260000.0, 280000.0, // Estimated
            "/images/Thruxton%20400.jpg",
            "A cafe racer based on the 400cc platform (Upcoming).",
            Arrays.asList(new SpecData("Engine", "398 cc"), new SpecData("Power", "39.5 bhp")));

        createBikeIfNotFound("Street Triple 765", triumph, 1000000.0, 1200000.0,
            "/images/Street%20Triple%20765.jpg",
            "The definitive street fighter.",
            Arrays.asList(new SpecData("Engine", "765 cc"), new SpecData("Power", "128 bhp")));
            
        createBikeIfNotFound("Daytona 660", triumph, 900000.0, 950000.0,
             "/images/Daytona%20660.jpg",
             "Dynamic sports performance with all day riding comfort.",
             Arrays.asList(new SpecData("Engine", "660 cc"), new SpecData("Power", "95 bhp")));

        createBikeIfNotFound("Bonneville Speedmaster", triumph, 1200000.0, 1300000.0,
             "/images/Bonneville%20SpeedMaster.jpg",
             "Classic custom attitude, comfortable cruiser riding position.",
             Arrays.asList(new SpecData("Engine", "1200 cc"), new SpecData("Power", "76.9 bhp")));

        // Yezdi
        createBikeIfNotFound("Roadster", yezdi, 206000.0, 214000.0,
            "/images/Roadster.jpg",
            "A stunning roadster with commanding presence.",
            Arrays.asList(new SpecData("Engine", "334 cc"), new SpecData("Power", "29 bhp")));

        createBikeIfNotFound("Adventure", yezdi, 219000.0, 229000.0,
            "/images/Adventure.jpg",
            "Designed for long distance touring and off-road adventures.",
            Arrays.asList(new SpecData("Engine", "334 cc"), new SpecData("Power", "29.8 bhp")));

        createBikeIfNotFound("Scrambler", yezdi, 210000.0, 220000.0,
            "/images/Scrambler.jpg",
            "A true scrambler built for fun.",
            Arrays.asList(new SpecData("Engine", "334 cc"), new SpecData("Power", "28.7 bhp")));

        // Jawa
        createBikeIfNotFound("Jawa 42 Bobber", java, 212000.0, 229000.0, // Assumed "Bobber" means 42 Bobber or Perak
             "/images/Jawa%2042%20Bobber.jpg",
             "The factory custom bobber.",
             Arrays.asList(new SpecData("Engine", "334 cc"), new SpecData("Power", "30.2 bhp")));

        createBikeIfNotFound("Jawa 42 FJ", java, 199000.0, 220000.0,
             "/images/Jawa%2042%20FJ.jpg",
             "The new sporty classic from Jawa.",
             Arrays.asList(new SpecData("Engine", "334 cc"), new SpecData("Power", "28.7 bhp")));

        System.out.println("Database seeding completed.");
    }

    private Brand createBrandIfNotFound(String name, String logoUrl) {
        return brandRepository.findAll().stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Creating Brand: " + name);
                    Brand brand = new Brand();
                    brand.setName(name);
                    brand.setLogoUrl(logoUrl);
                    return brandRepository.save(brand);
                });
    }

    private Bike createBikeIfNotFound(String name, Brand brand, Double priceMin, Double priceMax, String imageUrl, String description, List<SpecData> specs) {
        if (brand == null) return null;
        
        Bike bike = bikeRepository.findAll().stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(new Bike());

        System.out.println((bike.getId() == null ? "Creating" : "Updating") + " Bike: " + name);
        
        bike.setName(name);
        bike.setBrand(brand);
        bike.setPriceMin(priceMin);
        bike.setPriceMax(priceMax);
        bike.setImageUrl(imageUrl);
        bike.setDescription(description);
        
        Bike savedBike = bikeRepository.save(bike);

        // Update specs
        if (specs != null) {
            // Simplify: Delete old specs and re-add (or check existing)
            // For now, let's just add missing ones or update if logic allows. 
            // A simple approach for this seeder is to clear and re-add, but that might break IDs.
            // Let's just append for now or handle gracefully.
            // Better strategy for this simple app: Check if spec exists by key.
            
            for (SpecData s : specs) {
                // Check if spec exists
                boolean exists = false;
                if (savedBike.getSpecifications() != null) {
                    for (Specification existingSpec : savedBike.getSpecifications()) {
                        if (existingSpec.getSpecKey().equalsIgnoreCase(s.key)) {
                            existingSpec.setSpecValue(s.value);
                            specificationRepository.save(existingSpec);
                            exists = true;
                            break;
                        }
                    }
                }
                
                if (!exists) {
                    Specification spec = new Specification();
                    spec.setBike(savedBike);
                    spec.setSpecKey(s.key);
                    spec.setSpecValue(s.value);
                    specificationRepository.save(spec);
                }
            }
        }
        return savedBike;
    }

    // Simple helper class for defining specs inline
    private static class SpecData {
        String key;
        String value;
        public SpecData(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
