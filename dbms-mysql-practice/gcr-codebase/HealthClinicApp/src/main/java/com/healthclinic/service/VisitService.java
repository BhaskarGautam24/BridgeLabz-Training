package com.healthclinic.service;

import com.healthclinic.dao.VisitDAO;
import com.healthclinic.model.Visit;

public class VisitService {

    private VisitDAO dao = new VisitDAO();

    public void recordVisit(Visit v) throws Exception {
        dao.addVisit(v);
    }
}
