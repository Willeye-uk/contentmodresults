package uk.co.motors;


//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class ContentManagerResults {

    @PostMapping("/content")
    public ResponseEntity<Map<String, Object>> handleContentRequest(
            @RequestHeader("auth") String authHeader,
            @RequestBody Map<String, Object> requestBody) {

        // Check the authentication header
        if (!"xxx".equals(authHeader)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid authentication header");
        }

        // Process the JSON request body (you can add your logic here)
        System.out.println("Received request with body: " + requestBody);

        // You can manipulate the requestBody here, and construct a response
        // For this example, we'll just echo back the request
        return ResponseEntity.ok(requestBody);
    }
}
