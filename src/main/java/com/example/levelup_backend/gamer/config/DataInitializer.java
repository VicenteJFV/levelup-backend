package com.example.levelup_backend.gamer.config;

import com. example.levelup_backend.gamer. model.Product;
import com.example.levelup_backend.gamer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot. CommandLineRunner;
import org.springframework. stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String...  args) {
        // Solo inicializar si no hay productos en la base de datos
        if (productRepository.count() >= 5) {
            return;
        }

        List<Product> productos = List.of(
            new Product(
                null,
                "PlayStation 5 Slim",
                "Consola",
                549990,
                15,
                "Consola PlayStation 5 Slim con lector de discos.  Incluye control DualSense y base vertical. Experimenta el gaming de nueva generación con gráficos 4K y tiempos de carga ultrarrápidos.",
                "https://media.falabella.com/falabellaCL/126614736_01/w=800,h=800,fit=pad"
            ),
            new Product(
                null,
                "Xbox Series X",
                "Consola",
                599990,
                10,
                "La consola Xbox más potente de la historia. 12 teraflops de potencia, SSD de 1TB, y retrocompatibilidad con miles de juegos.  Incluye control inalámbrico Xbox.",
                "https://http2.mlstatic.com/D_NQ_NP_942133-MLA74651936102_022024-O.webp"
            ),
            new Product(
                null,
                "Nintendo Switch OLED",
                "Consola",
                389990,
                20,
                "Nintendo Switch modelo OLED con pantalla de 7 pulgadas, soporte ajustable, dock con puerto LAN y 64GB de almacenamiento interno. Perfecta para jugar en casa o en movimiento.",
                "https://d16c9dlthokxv6.cloudfront.net/catalog/product/cache/e83b319fe15d087a014efa16f11c0f36/c/o/consola_oled.png"
            ),
            new Product(
                null,
                "Teclado Mecánico Razer BlackWidow V4",
                "Periférico",
                189990,
                25,
                "Teclado mecánico gaming con switches Razer Green, iluminación RGB Chroma, reposamuñecas magnético y teclas macro dedicadas. Ideal para gamers competitivos.",
                "https://itshop.cl/cdn/shop/files/RZ03-04700200-R3U1-1.jpg?v=1745861388"
            ),
            new Product(
                null,
                "Mouse Logitech G Pro X Superlight",
                "Periférico",
                159990,
                30,
                "Mouse inalámbrico ultraligero de solo 63 gramos.  Sensor HERO 25K, hasta 70 horas de batería y diseño ambidiestro. El favorito de los jugadores profesionales de esports.",
                "https://progaming.cl/wp-content/uploads/2024/11/w-hm_lgm_20153_f2_transparent-36e1845c-899a-4bc0-baa4-8b3c993fd88d.png"
            ),
            new Product(
                null,
                "Audífonos HyperX Cloud III",
                "Periférico",
                129990,
                35,
                "Audífonos gaming con sonido DTS Headphone:X, micrófono con cancelación de ruido, almohadillas de espuma viscoelástica y compatibilidad multiplataforma.",
                "https://cintegral.cl/wp-content/uploads/2025/10/hyperx_cloud_iii_red_66x0049_main_1-600x600.webp"
            ),
            new Product(
                null,
                "Monitor Samsung Odyssey G5 27\"",
                "Periférico",
                349990,
                12,
                "Monitor curvo gaming de 27 pulgadas, resolución QHD 2560x1440, 165Hz, 1ms de respuesta y tecnología AMD FreeSync Premium. Sumérgete en tus juegos favoritos.",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSaZY0x19pyYQk_gh51I39UqR3e-tgxXMDEA&s"
            ),
            new Product(
                null,
                "Silla Gamer Cougar Armor One",
                "Accesorio",
                249990,
                8,
                "Silla ergonómica gaming con soporte lumbar ajustable, reposabrazos 2D, reclinable hasta 180°, base de acero y ruedas de nylon. Máximo confort para largas sesiones.",
                "https://todoclick.cl/5433016-large_default/silla_gamer_cougar_armor_one_royal_120kg_3marrgld_0001.jpg"
            ),
            new Product(
                null,
                "Control DualSense Edge",
                "Accesorio",
                229990,
                18,
                "El control profesional de PlayStation 5.  Palancas intercambiables, gatillos ajustables, botones traseros programables y estuche de transporte incluido.",
                "https://cl-cenco-pim-resizer.ecomm.cencosud.com/unsafe/adaptive-fit-in/3840x0/filters:quality(75)/prd-cl/product-medias/7f0fe8e8-42fe-4d45-b93b-fe514b068d47/MKH5WQAHW0/MKH5WQAHW0-1/1748981301238-MKH5WQAHW0-1-1.png"
            ),
            new Product(
                null,
                "Tarjeta de Expansión Seagate 1TB para Xbox",
                "Accesorio",
                279990,
                22,
                "Almacenamiento de expansión oficial para Xbox Series X|S. 1TB de capacidad con la misma velocidad del SSD interno. Plug and play, sin configuración.",
                "https://cl-cenco-pim-resizer.ecomm.cencosud.com/unsafe/adaptive-fit-in/3840x0/filters:quality(75)/prd-cl/product-medias/07e5e47e-21d9-4733-b67e-a91b4db3574d/MKHF6FSG60/MKHF6FSG60-1/1686355889986-MKHF6FSG60-1-1.jpg"
            )
        );

        productRepository.saveAll(productos);
        System.out.println("✅ DataInitializer: Se han cargado " + productos.size() + " productos iniciales.");
    }
}