package com.wangdamme.myapplication.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.wangdamme.myapplication.ui.home.HomeViewModel;
import com.wangdamme.myapplication.ui.save.SaveViewModel;
import com.wangdamme.myapplication.ui.search.SearchViewModel;

public class NewsViewModelFactory implements ViewModelProvider.Factory {

    private final NewsRepository repository;

    public NewsViewModelFactory(NewsRepository repository)
    {
        this.repository=repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(HomeViewModel.class))
        {
            return (T) new HomeViewModel(repository);
        }
        else if (modelClass.isAssignableFrom(SearchViewModel.class))
        {
            return (T) new SearchViewModel(repository);
        }
        else if (modelClass.isAssignableFrom(SaveViewModel.class))
        {
            return (T) new SaveViewModel(repository);
        }
        else
        {
            throw  new IllegalStateException("Unknown ViewModel!");
        }
    }
}
