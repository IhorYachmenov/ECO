package com.example.eco;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class EcologistAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public EcologistAdapter(@NonNull Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new EcologistFragment();
        } else if (position == 1) {
            return new FamousEcologistFragment();
        } else {
            return new ListOfAllEcologistFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_what_is_the_ecologist);
        } else if (position == 1){
            return mContext.getString(R.string.category_famous_ecologist);
        } else {
            return mContext.getString(R.string.category_all_ecologist);
        }
    }
}
