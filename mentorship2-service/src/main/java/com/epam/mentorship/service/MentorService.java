package com.epam.mentorship.service;

import java.util.List;

import com.epam.mentorship.model.Mentor;

public interface MentorService {

    Mentor create(Mentor entity);

    Mentor update(Mentor entity);

    void delete(Mentor entity);

    void delete(Long id);

    Mentor findById(Long id);

    List<Mentor> findMentors();

    List<Mentor> getMentorsByMenteesAmount(int menteesAmount,
            boolean onlyActive);
}
