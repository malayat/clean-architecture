package ec.solmedia.cleanarchitecture.data.repository.mapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import ec.solmedia.cleanarchitecture.data.entity.PersonEntity;
import ec.solmedia.cleanarchitecture.domain.model.PersonDomain;

@Singleton
public class PersonDomainToPersonEntityMapper extends Mapper<PersonDomain, PersonEntity> {

    @Inject
    public PersonDomainToPersonEntityMapper() {
    }

    @Override
    public PersonEntity map(PersonDomain value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PersonDomain reverseMap(PersonEntity value) {
        PersonDomain personDomain = new PersonDomain();
        personDomain.setDni(value.getDni());
        personDomain.setName(value.getName());
        personDomain.setLastName(value.getLastName());
        personDomain.setAge(value.getAge());
        personDomain.setPicture(value.getPicture());
        return personDomain;
    }
}
