import com.clinicmgmt.springclinicmgmt.dao.AuthGroupRepoI;
import com.clinicmgmt.springclinicmgmt.dao.DoctorsRepo;
import com.clinicmgmt.springclinicmgmt.dao.PatientsRepo;
import com.clinicmgmt.springclinicmgmt.models.AuthGroup;
import com.clinicmgmt.springclinicmgmt.models.Doctor;
import com.clinicmgmt.springclinicmgmt.services.DoctorService;
import com.clinicmgmt.springclinicmgmt.services.PatientService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j

public class MyCommandLineRunner implements CommandLineRunner {

    PatientsRepo patientsRepo;
    AuthGroupRepoI authGroupRepoI;
    DoctorsRepo doctorsRepo;
    DoctorService doctorService;
    PatientService patientService;
    @Autowired
    public MyCommandLineRunner(DoctorsRepo doctorsRepo, PatientService patientService, AuthGroupRepoI authGroupRepoI, PatientsRepo patientsRepo, DoctorService doctorService) {
        this.patientsRepo = patientsRepo;
        this.doctorsRepo = doctorsRepo;
        this.authGroupRepoI = authGroupRepoI;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @Override
    public void run(String... args) throws Exception {


        AuthGroup authGroup1 = new AuthGroup ("username","ROLE_ADMIN");
        authGroupRepoI.save(authGroup1);



        Doctor Owens = new Doctor("Cindy Owens", "username", "cindyowens@gmail.com","password", "08-23-1997", "Female", "123 street", "468-876-3456");
        doctorsRepo.save(Owens);

    }
}