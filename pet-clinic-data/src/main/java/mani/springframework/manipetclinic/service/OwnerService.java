package mani.springframework.manipetclinic.service;

import mani.springframework.manipetclinic.model.Owner;

public interface OwnerService  extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);

}
