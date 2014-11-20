package com.tale.androidutils.meta;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.Stack;

/**
 * Created by TALE on 7/23/2014.
 */
public class FragmentPresenter {

    private final int fragmentContainerId;
    private final FragmentManager fragmentManager;
    private Stack<Fragment> mBackStack;
    private int curPos;

    public FragmentPresenter(FragmentManager fragmentManager, int fragmentContainerId) {
        this.fragmentContainerId = fragmentContainerId;
        this.fragmentManager = fragmentManager;
    }

    public void clearStack() {
        if (mBackStack != null) {
            mBackStack.clear();
            mBackStack = null;
        }
    }
//
//    public void showScreen(Fragment fragment, boolean addToBackStack) {
//        showScreen(fragment, addToBackStack, R.anim.slide_in_right, R.anim.slide_out_left);
//    }
//
//    public void showScreen(Fragment fragment, boolean addToBackStack, int index) {
//        if (index < curPos) {
//            showScreen(fragment, addToBackStack, R.anim.slide_in_left, R.anim.slide_out_right);
//        } else {
//            showScreen(fragment, addToBackStack);
//        }
//        curPos = index;
//    }

    /**
     * Change main fragment screen to target screen
     */
    public void showScreen(Fragment fragment, boolean addToBackStack, int animEnter, int animExit) {
        if (addToBackStack) {
            final Fragment curFrag = fragmentManager.findFragmentById(fragmentContainerId);
            if (curFrag != null) {
                if (mBackStack == null) {
                    mBackStack = new Stack<Fragment>();
                }
                mBackStack.push(curFrag);
            }
        }

        final String tag = "FRAG_" + fragment.hashCode();
        if (fragmentManager.findFragmentByTag(tag) == null) {
            final FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(animEnter, animExit);
            ft.replace(fragmentContainerId, fragment, tag);
            ft.commit();
        }
    }

    public boolean navigateBack(int animEnter, int animExit) {
        if (mBackStack == null || mBackStack.isEmpty()) {
            return false;
        }
        final Fragment fragment = mBackStack.pop();
        final String tag = "FRAG_" + fragment.hashCode();
        if (fragmentManager.findFragmentByTag(tag) == null) {
            final FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(animEnter, animExit);
            ft.replace(fragmentContainerId, fragment, tag);
            ft.commit();
            curPos--;
        }
        return true;
    }

    public boolean navigateBack() {
        if (mBackStack == null || mBackStack.isEmpty()) {
            return false;
        }
        final Fragment fragment = mBackStack.pop();
        final String tag = "FRAG_" + fragment.hashCode();
        if (fragmentManager.findFragmentByTag(tag) == null) {
            final FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(fragmentContainerId, fragment, tag);
            ft.commit();
            curPos--;
        }
        return true;
    }

}
