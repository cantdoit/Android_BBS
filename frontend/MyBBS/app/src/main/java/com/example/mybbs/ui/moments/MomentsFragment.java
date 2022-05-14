package com.example.mybbs.ui.moments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mybbs.databinding.FragmentMomentsBinding;

public class MomentsFragment extends Fragment {

    private FragmentMomentsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MomentsViewModel momentsViewModel =
                new ViewModelProvider(this).get(MomentsViewModel.class);

        binding = FragmentMomentsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMoments;
        momentsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}