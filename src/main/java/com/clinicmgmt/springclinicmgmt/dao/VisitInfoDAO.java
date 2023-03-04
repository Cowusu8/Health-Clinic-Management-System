package com.clinicmgmt.springclinicmgmt.dao;

import com.clinicmgmt.springclinicmgmt.models.VisitInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VisitInfoDAO {
    private Connection conn;

    public VisitInfoDAO(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean addVisitInfo(VisitInfo visitInfo) {
        boolean f = false;
        try {
            String sql = "insert into visitinfo(visitid, billing, diagnosis, prescription, visit_date) values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, visitInfo.getId());
            ps.setString(2, visitInfo.getDiagnosis());
            ps.setBoolean(3, visitInfo.getBilled());
            ps.setString(4, visitInfo.getPrescription());
            ps.setString(5, visitInfo.getVisitDate());

            int i = ps.executeUpdate();
            if(i==1) {
                f=true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}

