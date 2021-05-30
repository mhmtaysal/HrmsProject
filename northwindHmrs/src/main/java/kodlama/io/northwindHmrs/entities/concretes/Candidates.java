package kodlama.io.northwindHmrs.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "candidatesid")
@EqualsAndHashCode(callSuper=true)

public class Candidates extends Users {
    
    @Column(name = "firstname")
    private String firstName;
    
    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "nationalidentity")
    private String nationalIdentity;
    
    @Column(name = "dateofbirth")
    private Date dateOfBirth;
    
}
