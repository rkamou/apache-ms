package com.apache.controller;

import com.apache.model.Order;
import com.apache.service.OrderService;
import com.apache.service.impl.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException; 
import java.util.List;

@RestController
@CrossOrigin(origins={"http://localhost:4200","http://localhost","http://localhost:4201"},allowedHeaders = "*")
@RequestMapping(value = "/eartwork/api/orders",produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadRestController.class);
    @Autowired
    OrderService orderService;
    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping(value="/list")
    public List<Order> getListArtworks() {
        /*Order order = new Order();
        order.setDateCreated(LocalDate.now());
        order.setStatus("Art");
        order.setShippingInfo(new ShippingInfo("Doc",90.0));
        order.getOrderDetail().add(new OrderDetail(1,12.15));
        order.setDateShipped(LocalDate.now());orderService.save(order);*/
        return orderService.getOrders();
    }

    @GetMapping(value="/getById/{id}")
    public Order getOrder(@PathVariable Integer id){
        return this.orderService.getOrderById(id);
    }



    @PostMapping(value="/add")
    public Order addOrder(@Valid @RequestBody Order order){
        return this.orderService.save(order);
    }

    @PutMapping(value = "/update/{id}")
    public Order updateBook( @RequestBody String statusOrder, @PathVariable Integer id) {

        Order order = this.orderService.getOrderById(id);
        if(order != null){
            System.out.println("Update Order ID# : "+id+", to Status: "+ statusOrder);
            order.setStatus(statusOrder);
            orderService.save(order);
            return order;
        }
        System.out.println("----------------------------------- Echec Update ?????");
        return null;

    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }




    @DeleteMapping(value = "/delete/{id}")

    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);

    }


}
