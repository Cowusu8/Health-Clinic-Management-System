package org.crystalowusu.springclinicmgmt;

import lombok.extern.slf4j.Slf4j;
import org.crystalowusu.springclinicmgmt.dao.AuthGroupRepoI;
import org.crystalowusu.springclinicmgmt.dao.DoctorsRepo;
import org.crystalowusu.springclinicmgmt.dao.PatientsRepo;
import org.crystalowusu.springclinicmgmt.models.AuthGroup;
import org.crystalowusu.springclinicmgmt.models.Doctor;
import org.crystalowusu.springclinicmgmt.services.DoctorService;
import org.crystalowusu.springclinicmgmt.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component @Slf4j
public class MyCommandLineRunner implements CommandLineRunner {
    PatientsRepo patientsRepo;
    AuthGroupRepoI authGroupRepoI;
    DoctorsRepo doctorsRepo;
    DoctorService doctorService;
    PatientService patientService;

    @Autowired
    public MyCommandLineRunner(PatientsRepo patientsRepo, AuthGroupRepoI authGroupRepoI, DoctorsRepo doctorsRepo, DoctorService doctorService,  PatientService patientService) {
        this.patientsRepo = patientsRepo;
        this.authGroupRepoI = authGroupRepoI;
        this.doctorsRepo = doctorsRepo;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @Override
    public void run(String... args) throws Exception {



        AuthGroup authGroup1 = new AuthGroup ("crystal1","ROLE_ADMIN");
        AuthGroup authGroup2 = new AuthGroup ("crystal2","ROLE_ADMIN");
        AuthGroup authGroup3 = new AuthGroup ("crystal3","ROLE_ADMIN");
        AuthGroup authGroup4 = new AuthGroup ("crystal4","ROLE_ADMIN");
        authGroupRepoI.save(authGroup1);
        authGroupRepoI.save(authGroup2);
        authGroupRepoI.save(authGroup3);
        authGroupRepoI.save(authGroup4);



        Doctor Owens1 = new Doctor("Cindy Owens", "03-24-1977","Female", "983-223-1927", "123 street", "cindyowen@gmail.com", "password");
        Doctor Owens2 = new Doctor("Brittany Owens","08-13-1987","male", "508-235-1997", "2673 street", "crystalowen@gmail.com", "password");
        doctorsRepo.save(Owens1);
        doctorsRepo.save(Owens2);


        AuthGroup authGroup5 = new AuthGroup ("smithdoe","ROLE_DOCTOR");
        AuthGroup authGroup6 = new AuthGroup ("smith1","ROLE_DOCTOR");
        AuthGroup authGroup7 = new AuthGroup ("smith2","ROLE_DOCTOR");
        AuthGroup authGroup8 = new AuthGroup ("smith3","ROLE_DOCTOR");
        authGroupRepoI.save(authGroup5);
        authGroupRepoI.save(authGroup6);
        authGroupRepoI.save(authGroup7);
        authGroupRepoI.save(authGroup8);

//        /*List<CombineUsers> users = new ArrayList<>();
//        users = doctorsRepo.findAll().stream().map(doctor -> new CombineUsers(doctor.getUsername(), doctor.getPassword())).collect(Collectors.toList());
//        users.addAll(adminRepo.findAll().stream().map(admin -> new CombineUsers(admin.getUsername(), admin.getPassword())).collect(Collectors.toList()));
//        CombineUsers u = users.stream()
//                .filter(combineUsers -> combineUsers.getUsername().equals("crystal"))
//                .map(combineUsers -> new CombineUsers(combineUsers.getUsername(), combineUsers.getPassword())).findFirst().get();
//        log.warn(users.toString());
//        log.warn(u.toString());*/
//
    }
}



