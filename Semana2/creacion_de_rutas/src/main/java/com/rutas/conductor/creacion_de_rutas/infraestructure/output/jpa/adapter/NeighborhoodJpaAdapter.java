package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.adapter;

import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.spi.INeighborhoodPersistencePort;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.NeighborhoodAlreadyExistsException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.NeighborhoodNameNotPresentException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.exception.NeighborhoodNotFoundException;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity.NeighborhoodEntity;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.mapper.INeighborhoodEntityMapper;
import com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.repository.INeighborhoodRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NeighborhoodJpaAdapter implements INeighborhoodPersistencePort {
    private final INeighborhoodRepository neighborhoodRepository;
    private final INeighborhoodEntityMapper neighborhoodEntityMapper;

    @Override
    public void saveNeighborhood(Neighborhood neighborhood) {
        if (neighborhoodRepository.findByNeighborhoodName(neighborhood.getNeighborhoodName()).isPresent()) {
            throw new NeighborhoodAlreadyExistsException();
        }
        neighborhoodRepository.save(neighborhoodEntityMapper.toNeighborhoodEntity(neighborhood));
    }

    @Override
    public void updateNeighborhood(Neighborhood neighborhood) {
        if (neighborhood.getNeighborhoodName()!= null){
            NeighborhoodEntity neighborhoodToUpdate = neighborhoodRepository.findByNeighborhoodName(neighborhood.getNeighborhoodName()).orElseThrow(NeighborhoodNotFoundException::new);
            if (neighborhood.getNeighborhoodDescription() != null) {
                neighborhoodToUpdate.setNeighborhoodDescription(neighborhood.getNeighborhoodDescription());
            }
            neighborhoodRepository.save(neighborhoodToUpdate);
        } else {
            throw new NeighborhoodNameNotPresentException();
        }

    }

    @Override
    public void deleteNeighborhood(String neighborhoodName) {
        if (neighborhoodRepository.findByNeighborhoodName(neighborhoodName).isEmpty()) {
            throw new NeighborhoodNotFoundException();
        }
        neighborhoodRepository.deleteByNeighborhoodName(neighborhoodName);
    }

    @Override
    public Neighborhood getNeighborhood(Long neighborhoodId) {
        NeighborhoodEntity neighborhoodInDB = neighborhoodRepository.findById(neighborhoodId).orElseThrow(NeighborhoodNotFoundException::new);
        return neighborhoodEntityMapper.toNeighborhood(neighborhoodInDB);
    }

    @Override
    public  Neighborhood findNeighborhoodByName(String neighborhoodName) {
        NeighborhoodEntity neighborhoodInDB = neighborhoodRepository.findByNeighborhoodName(neighborhoodName).orElseThrow(NeighborhoodNotFoundException::new);
        return neighborhoodEntityMapper.toNeighborhood(neighborhoodInDB);
    }

    @Override
    public List<Neighborhood> getAllNeighborhoods() {
        return neighborhoodEntityMapper.toNeighborhoodList(neighborhoodRepository.findAll());
    }
}
