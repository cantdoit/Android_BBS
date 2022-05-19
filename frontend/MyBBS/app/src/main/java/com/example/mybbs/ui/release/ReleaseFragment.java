package com.example.mybbs.ui.release;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mybbs.databinding.FragmentReleaseBinding;

public class ReleaseFragment extends Fragment {

    private FragmentReleaseBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ReleaseViewModel releaseViewModel =
                new ViewModelProvider(this).get(ReleaseViewModel.class);

        binding = FragmentReleaseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textRelease;
        releaseViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}