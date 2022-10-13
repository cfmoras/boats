package com.backapiboats.repository;

import com.backapiboats.model.ScoreModel;
import com.backapiboats.repository.crudrepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<ScoreModel> getAllScores() {
        return (List<ScoreModel>) scoreCrudRepository.findAll();
    }

    public Optional<ScoreModel> getScore(Integer id) {
        return scoreCrudRepository.findById(id);
    }

    public ScoreModel saveScore(ScoreModel scoreModel) {
        return scoreCrudRepository.save(scoreModel);
    }

    public boolean deleteScore(ScoreModel scoreModel) {
        scoreCrudRepository.delete(scoreModel);
        return true;
    }

    public ScoreModel updateScore(ScoreModel scoreModel) {
        return scoreCrudRepository.save(scoreModel);
    }
}
