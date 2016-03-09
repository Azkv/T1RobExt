package com.testing.azarkovic.testing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by azarkovic on 3.3.2016..
 */
public class TestFragment extends Fragment
{
    private Person person;
    private TextView name,title;
    public boolean scaled = false;

    private ImageView img;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View v =  inflater.inflate(R.layout.testfragment_layout, container, false);
        ButterKnife.inject(v);
        img = ((ImageView) v.findViewById(R.id.fragment_img));
        img.setImageResource(person.getImgRes());
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!scaled)
                {
                    FragmentAnimations.ScaleUp(TestFragment.this);
                    scaled = true;
                }
                else
                {
                    FragmentAnimations.ScaleDown(TestFragment.this);
                    scaled = false;
                }
            }
        });
        name =((TextView) v.findViewById(R.id.fragment_name));
        name.setText(person.getName());
        title = ((TextView) v.findViewById(R.id.fragment_title));
        title.setText(person.getTitle());
        setIcons(v);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {

        Bundle extras = this.getArguments();
        person = (Person)extras.getSerializable(Person.SERIALIZATION_KEY);
        super.onCreate(savedInstanceState);
    }

    public static TestFragment newInstance(Person person)
    {
        TestFragment tf = new TestFragment();
        Bundle b = new Bundle();
        b.putSerializable(Person.SERIALIZATION_KEY, person);
        tf.setArguments(b);

        return tf;
    }

    public void setIcons(View v)
    {
        LinearLayout container  = (LinearLayout)v.findViewById(R.id.fragment_icons_line);
        Icon icoProfile = new Icon(v.getContext(), Icon.IconType.PROFILE);
        Icon icoMessage = new Icon(v.getContext(), Icon.IconType.MESSAGE);
        Icon icoAddFriend = new Icon(v.getContext(), Icon.IconType.ADD_FRIEND);
        container.addView(icoProfile);
        container.addView(icoMessage);
        container.addView(icoAddFriend);

    }


    // G/S
    public ImageView getImg() {
        return img;
    }

    public TextView getName() {
        return name;
    }

    public TextView getTitle() {
        return title;
    }
}
