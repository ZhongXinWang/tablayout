package wzx.app.com.tablayout.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wzx.app.com.tablayout.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabLayoutFragment extends Fragment {

    private static final String TAG="tag";

    public TabLayoutFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_layout, container, false);
    }

    public static TabLayoutFragment newInstance(String text) {

        Bundle args = new Bundle();
        args.putString(TAG,text);
        TabLayoutFragment fragment = new TabLayoutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView text = (TextView) view.findViewById(R.id.fragment_text);
        text.setText(getArguments().getString(TAG));
    }
}
