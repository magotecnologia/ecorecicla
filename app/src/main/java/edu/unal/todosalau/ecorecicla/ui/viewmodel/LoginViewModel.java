package edu.unal.todosalau.ecorecicla.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import edu.unal.todosalau.ecorecicla.ui.state.LoginState;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<LoginState> _state;

    public LiveData<LoginState> getState() {
        return _state;
    }

    public LoginViewModel() {
        _state = new MutableLiveData<>();
        _state.setValue(new LoginState());
    }

    public void login(String user, String password) {
        LoginState state = _state.getValue();
        //TODO:En este metodo se implementa la logica de validacion de usuario
        state.setLogged(true);
        _state.setValue(state);
    }

}