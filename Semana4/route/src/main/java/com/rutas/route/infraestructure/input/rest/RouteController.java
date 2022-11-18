package com.rutas.route.infraestructure.input.rest;

import com.rutas.route.applicaton.dto.RouteRequest;
import com.rutas.route.applicaton.dto.RouteRequestClient;
import com.rutas.route.applicaton.dto.RouteResponse;
import com.rutas.route.applicaton.handler.IRouteHandler;
import com.rutas.route.infraestructure.output.feing.entity.NeighborhoodRequest;
import com.rutas.route.infraestructure.output.feing.entity.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/route")
public class RouteController {
    private final IRouteHandler routeHandler;

    @Operation(summary = "Add a new route")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Route created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Route already exists", content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<Void> saveRouteInDB(@RequestBody RouteRequestClient routeRequestClient, @RequestHeader(value = "Authorization") String authorization){
        routeHandler.saveRouteInDB(routeRequestClient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get all the routes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All routes returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserRequest.class)))),
            @ApiResponse(responseCode = "404", description = "Route not found", content = @Content)
    })
    @GetMapping("/getAll")
    public ResponseEntity<List<RouteResponse>> getAllRoutesFromDB(@RequestHeader(value = "Authorization") String authorization){
        return ResponseEntity.ok(routeHandler.getAllRoutesFromDB());
    }

    @Operation(summary = "Get a route by his name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Route found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = NeighborhoodRequest.class))),
            @ApiResponse(responseCode = "404", description = "Route not found", content = @Content)
    })
    @GetMapping("/get/{name}")
    public ResponseEntity<RouteResponse> getRouteByNameFromDB(@PathVariable(name = "name") String routeName, @RequestHeader(value = "Authorization") String authorization){
        return ResponseEntity.ok(routeHandler.getRouteFromDBByName(routeName));
    }

    @Operation(summary = "Update an existing route")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Route updated", content = @Content),
            @ApiResponse(responseCode = "404", description = "Route not found", content = @Content)
    })
    @PutMapping("/update")
    public ResponseEntity<Void> updateRouteInDB(@RequestBody RouteRequest routeRequest, @RequestHeader(value = "Authorization") String authorization){
        routeHandler.updateRouteInDB(routeRequest);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete an existing route")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Route deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "Route not found", content = @Content)
    })
    @DeleteMapping("/delete/{routeName}")
    public ResponseEntity<Void> deleteRouteInDB(@PathVariable String routeName, @RequestHeader(value = "Authorization") String authorization){
        routeHandler.deleteRouteInDB(routeName);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping  ("/deleteTravel/{routeName}/{travelDate}")
    public ResponseEntity<Void> deleteTravelInDB(@PathVariable String routeName, @PathVariable String travelDate, @RequestHeader(value = "Authorization") String authorization){
        routeHandler.deleteTravelInDB(routeName, travelDate);
        return ResponseEntity.noContent().build();
    }
}

