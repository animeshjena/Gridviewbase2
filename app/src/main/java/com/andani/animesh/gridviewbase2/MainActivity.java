package com.andani.animesh.gridviewbase2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        Andani adapter=new Andani(this);
        gridView.setAdapter(adapter);
    }
}

class Singleitem
{
    int imgId;
    String picname;
    Singleitem(int imgId,String picname)
    {
        this.imgId=imgId;
        this.picname=picname;
    }

}
class Andani extends BaseAdapter
{
    ArrayList<Singleitem> arrayList;
    Context c;
    Andani(Context c)
    {
        arrayList=new ArrayList<Singleitem>();
        Resources resources=c.getResources();
        String[]data=resources.getStringArray(R.array.data);
        int[]pic={R.drawable.pi1,R.drawable.pi3,R.drawable.pi4,R.drawable.pi6,R.drawable.pi7,R.drawable.pic7,R.drawable.dango_nyan05,R.drawable.download};
        for(int i=0;i<8;i++)
        {
            arrayList.add(new Singleitem(pic[i],data[i]));
        }
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    class Viewholder
    {
        ImageView pic;
        Viewholder(View v)
        {
            pic=(ImageView)v.findViewById(R.id.imageView);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v=convertView;Viewholder viewholder=null;
        if(v==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=layoutInflater.inflate(R.layout.single_item,parent,false);
            viewholder=new Viewholder(v);
            v.setTag(viewholder);

        }
        else
        {
           viewholder=(Viewholder)v.getTag();
        }
        Singleitem si=arrayList.get(position);
        viewholder.pic.setImageResource(si.imgId);

        return v;
    }
}
