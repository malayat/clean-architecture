package ec.solmedia.cleanarchitecture.view.viewmodel.mapper;

import javax.inject.Inject;

import ec.solmedia.cleanarchitecture.data.repository.mapper.Mapper;
import ec.solmedia.cleanarchitecture.domain.model.PersonDomain;
import ec.solmedia.cleanarchitecture.view.viewmodel.PersonViewModel;


public class PersonViewModelToPersonMapper extends Mapper<PersonViewModel, PersonDomain> {

    @Inject
    public PersonViewModelToPersonMapper() {
    }

    @Override
    public PersonDomain map(PersonViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PersonViewModel reverseMap(PersonDomain value) {
        PersonViewModel personViewModel = new PersonViewModel();
        personViewModel.setCedula(value.getDni());
        personViewModel.setNombre(value.getName());
        personViewModel.setApellido(value.getLastName());
        personViewModel.setEdad(value.getAge());
        personViewModel.setFoto(value.getPicture());
        return personViewModel;
    }
}
