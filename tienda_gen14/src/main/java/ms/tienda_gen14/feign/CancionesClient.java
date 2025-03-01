package ms.tienda_gen14.feign;

import ms.tienda_gen14.model.Cancion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "cancion", url = "https://67c125c061d8935867e201b8.mockapi.io/")
public interface CancionesClient {

    @GetMapping("/cancion")
    public List<Cancion> getAllData();

    @GetMapping("/cancion/{id}")
    public Cancion getById(@PathVariable("id") Long id);

    @PostMapping("/cancion")
    public Cancion saveCancion(@RequestBody Cancion cancion);

    @PutMapping("/cancion/{id}")
    public Cancion updateCancion(@PathVariable Long id,
                                 @RequestBody Cancion cancion);

    @DeleteMapping("/cancion/{id}")
    public String deleteCancion(@PathVariable("id") Long id);

}
