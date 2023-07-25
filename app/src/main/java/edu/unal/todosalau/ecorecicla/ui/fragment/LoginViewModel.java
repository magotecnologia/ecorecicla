package edu.unal.todosalau.ecorecicla.ui.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import edu.unal.todosalau.ecorecicla.ui.state.LoginState;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<LoginState> _state;
    public LiveData<LoginState> state= _state;

    LoginViewModel(){
        _state= new MutableLiveData<>();
        _state.setValue(new LoginState());
    }

}