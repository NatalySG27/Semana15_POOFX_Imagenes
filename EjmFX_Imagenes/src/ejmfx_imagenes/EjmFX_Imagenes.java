/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejmfx_imagenes;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author UCF20410
 */
public class EjmFX_Imagenes extends Application {
private ImageView imagenProducto;
private Map<String, String> imagenes; // Producto → Ruta de imagen
@Override
public void start(Stage stage) {
VBox contenedorPrincipal = new VBox(15);
contenedorPrincipal.setStyle("-fx-padding: 20;");
imagenProducto = new ImageView();
imagenProducto.setFitWidth(200);
imagenProducto.setFitHeight(150);
imagenProducto.setPreserveRatio(true);
// Diccionario con productos y su imagen
imagenes = new HashMap<>();
imagenes.put("Cámara",
"file:src/EjmFX_Imagenes/imagenes/camara.jpg");
imagenes.put("Laptop",
"file:src/EjmFX_Imagenes/imagenes/laptop.jpg");
imagenes.put("Auriculares",
"file:src/EjmFX_Imagenes/imagenes/auriculares.jpg");
for (String nombre: imagenes.keySet()) {
HBox fila = crearFilaProducto(nombre);
contenedorPrincipal.getChildren().add(fila);
}

contenedorPrincipal.getChildren().add(imagenProducto);
Scene scene = new Scene(contenedorPrincipal, 400, 500);
stage.setTitle("Productos");
stage.setScene(scene);
stage.show();
}
private HBox crearFilaProducto(String nombreProducto) {
    Label nombre = new Label(nombreProducto);
    Button ver = new Button("Ver detalle");
    ver.setOnAction(e -> {
    String ruta = imagenes.get(nombreProducto);
    imagenProducto.setImage(new Image(ruta));
});
    HBox fila = new HBox(10, nombre, ver);
    return fila;
    }
public static void main(String[] args) {
    launch(args);
    }
}
