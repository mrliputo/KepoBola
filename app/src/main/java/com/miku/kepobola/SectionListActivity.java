package com.miku.kepobola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SectionListActivity extends AppCompatActivity {

    String[] listArray={"1) Lapangan Permainan",
            "2) Bola",
            "3) Pemain",
            "4) Perlengkapan Pemain",
            "5) Wasit",
            "6) Ofisial Pertandingan Lain",
            "7) Lamanya Pertandingan",
            "8) Memulai dan memulai kembali permainan",
            "9) Bola di dalam dan di luar permainan",
            "10) Menentukan pemenang pertandingan",
            "11) Ofsaid",
            "12) Pelanggaran & kelakuan tidak sopan",
            "13) Tendangan bebas",
            "14) Tendangan pinalti",
            "15) Lemparan kedalam",
            "16) Tendangan gawang",
            "17) Tendangan sudut",
            "*) Amendments",
            "*) Perubahan LOTG",
            "*) Video lainnya"};

    ListView listview;
    String fileContent;
    String titleContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Daftar Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listArray);
        listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                boolean list = true;

                switch (position){
                    case 0:
                        fileContent = "lapangan_permainan.html";
                        titleContent = "LAPANGAN PERMAINAN";
                        break;
                    case 1:
                        fileContent = "bola.html";
                        titleContent = "BOLA";
                        break;
                    case 2:
                        fileContent = "pemain.html";
                        titleContent = "PEMAIN";
                        break;
                    case 3:
                        fileContent = "perlengkapan_pemain.html";
                        titleContent = "PERLENGKAPAN PEMAIN";
                        break;
                    case 4:
                        fileContent = "wasit.html";
                        titleContent = "WASIT";
                        break;
                    case 5:
                        fileContent = "other_official.html";
                        titleContent = "OFISIAL PERTANDINGAN LAIN";
                        break;
                    case 6:
                        fileContent = "lama_pertandingan.html";
                        titleContent = "LAMANYA PERTANDINGAN";
                        break;
                    case 7:
                        fileContent = "Mulai_pertandingan.html";
                        titleContent = "MEMULAI DAN MEMULAI KEMBALI PERMAINAN";
                        break;
                    case 8:
                        fileContent = "bola_luardalam.html";
                        titleContent = "BOLA DI DALAM DAN DI LUAR LAPANGAN";
                        break;
                    case 9:
                        fileContent = "hasil_pertandingan.html";
                        titleContent = "MENENTUKAN PEMENANG PERTANDINGAN";
                        break;
                    case 10:
                        fileContent = "offside.html";
                        titleContent = "OFSAID";
                        break;
                    case 11:
                        fileContent = "pelanggaran.html";
                        titleContent = "PELANGGARAN DAN KELAKUAN YANG TIDAK SOPAN";
                        break;
                    case 12:
                        fileContent = "tendangan_bebas.html";
                        titleContent = "TENDANGAN BEBAS";
                        break;
                    case 13:
                        fileContent = "pinalti.html";
                        titleContent = "TENDANGAN PINALTI";
                        break;
                    case 14:
                        fileContent = "lemparan_dalam.html";
                        titleContent = "LEMPARAN KEDALAM";
                        break;
                    case 15:
                        fileContent = "tendangan_gawang.html";
                        titleContent = "TENDANGAN GAWANG";
                        break;
                    case 16:
                        fileContent = "tendangan_sudut.html";
                        titleContent = "TENDANGAN SUDUT";
                        break;
                    case 17:
                        fileContent = "amendments.html";
                        titleContent = "AMENDMENTS";
                        break;
                    case 18:
                        fileContent = "perubahan_lotg.html";
                        titleContent = "PERUBAHAN LOTG";
                        break;
                    case 19:
                        list = false;
                        break;
                    default:
                        fileContent = "lapangan_permainan.html";
                        titleContent = "Lapangan Permainan";
                        break;
                }

                if(list) {
                    Intent intent = new Intent(SectionListActivity.this, ContentActivity.class);
                    intent.putExtra("fileContent",  fileContent);
                    intent.putExtra("titleContent", titleContent);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(SectionListActivity.this, ActivityVideoList.class);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
