package ms.tienda_gen14.feign;

import ms.tienda_gen14.model.Tienda;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Tienda", url = "https://67c7a10fc19eb8753e7a3690.mockapi.io")
public interface TiendaClient {

    @GetMapping("/Tienda")
    public List<Tienda> getData();

    @GetMapping("/Tienda/{id}")
    public Tienda getDataById(@PathVariable Long id);


    // Endpoint POST: Crear una nueva tienda
    @PostMapping("/Tienda")
    public Tienda createTienda(@RequestBody Tienda tienda);

    // Endpoint PUT: Actualizar una tienda existente
    @PutMapping("/Tienda/{id}")
    public Tienda updateTienda(@PathVariable Long id, @RequestBody Tienda tienda);

    // Endpoint DELETE: Eliminar una tienda por su ID
    @DeleteMapping("/Tienda/{id}")
    public void deleteTienda(@PathVariable Long id);
}