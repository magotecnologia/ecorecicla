package edu.unal.todosalau.ecorecicla.di;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import edu.unal.todosalau.ecorecicla.data.EcoreciclaDatabase;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Singleton
    @Provides
    public EcoreciclaDatabase provideDataBase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, EcoreciclaDatabase.class, "ecorecicla").build();
    }

}
