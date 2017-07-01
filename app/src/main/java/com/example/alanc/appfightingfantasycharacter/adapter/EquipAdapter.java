package com.example.alanc.appfightingfantasycharacter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alanc.appfightingfantasycharacter.R;
import com.example.alanc.appfightingfantasycharacter.model.Equip;

import java.util.List;

/**
 * Created by alanc on 26/05/2017.
 */

public class EquipAdapter extends BaseAdapter {
    private List<Equip> listaEquip;
    private Context contexto;

    public EquipAdapter(List<Equip> listaEquip, Context contexto) {
        this.listaEquip = listaEquip;
        this.contexto = contexto;
    }

    public void setListaEquip(List<Equip> listaEquip) {
        this.listaEquip = listaEquip;
    }

    @Override
    public int getCount() {
        return listaEquip.size();
    }

    @Override
    public Object getItem(int position) {
        return listaEquip.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Equip equip = listaEquip.get(position);

        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item,null);

        TextView textoNome = (TextView) view.findViewById(R.id.textoNome);
        textoNome.setText(equip.getNome());

        TextView textoDescricao = (TextView) view.findViewById(R.id.textoDescricao);
        textoDescricao.setText(equip.getDescricao());

        return view;
    }

}