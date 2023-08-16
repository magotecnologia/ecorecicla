package edu.unal.todosalau.ecorecicla.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import edu.unal.todosalau.ecorecicla.exception.NotFoundUser;
import edu.unal.todosalau.ecorecicla.repository.AuthRepository;
import edu.unal.todosalau.ecorecicla.ui.state.LoginState;

@HiltViewModel
public class LoginViewModel extends ViewModel {
    private final AuthRepository repository;
    private MutableLiveData<LoginState> _state;

    public LiveData<LoginState> getState() {
        return _state;
    }

    @Inject
    public LoginViewModel(AuthRepository repository) {
        _state = new MutableLiveData<>();
        _state.setValue(new LoginState());
        this.repository = repository;
    }

    public void login() {
        LoginState state = _state.getValue();
        try {
            repository.getUserByNameAndPass(state.getUsername(), state.getPassword());
            state.setLogged(true);
        } catch (NotFoundUser e) {
            state.setError(e.getMessage());
        } finally {
            _state.setValue(state);
        }
    }

    public void setUser(String user) {
        LoginState state = _state.getValue();
        state.setUsername(user);
        _state.setValue(state);
    }

    public void setPassword(String password) {
        LoginState state = _state.getValue();
        state.setPassword(password);
        _state.setValue(state);
    }

}