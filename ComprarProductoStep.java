package steps;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class ComprarProductoSteps extends UIInteractionSteps {

    @Step("Abrir página principal")
    public void abrirPagina() {
        openUrl("https://www.demoblaze.com");
    }

    @Step("Agregar producto al carrito: {0}")
    public void agregarProductoAlCarrito(String nombreProducto) {
        find(By.linkText(nombreProducto)).click();
        find(By.linkText("Add to cart")).click();
        getDriver().switchTo().alert().accept();
        find(By.id("nava")).click(); // Regresar a inicio
    }

    @Step("Ir al carrito")
    public void irAlCarrito() {
        find(By.id("cartur")).click();
    }

    @Step("Completar formulario de compra")
    public void completarFormulario(String name, String country, String city, String card, String month, String year) {
        find(By.xpath("//button[text()='Place Order']")).click();
        find(By.id("name")).sendKeys(name);
        find(By.id("country")).sendKeys(country);
        find(By.id("city")).sendKeys(city);
        find(By.id("card")).sendKeys(card);
        find(By.id("month")).sendKeys(month);
        find(By.id("year")).sendKeys(year);
    }

    @Step("Finalizar compra")
    public void finalizarCompra() {
        find(By.xpath("//button[text()='Purchase']")).click();
        find(By.xpath("//button[text()='OK']")).click();
    }
}
