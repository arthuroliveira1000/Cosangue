package tcc.cosangueapp.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import tcc.cosangueapp.R;
import tcc.cosangueapp.pojos.Acao;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.AcaoViewHolder>{


    List<Acao> acoes;

   public RVAdapter(List<Acao> acoes){
        this.acoes = acoes;
    }


    // AQUI VAI O LAYOUT DE CADA ITEM DO RECYCLER VIEW
    @Override
    public AcaoViewHolder  onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_view, viewGroup, false);
        AcaoViewHolder avh = new AcaoViewHolder(v);
        return avh;
    }


    //aqui tu seta  todos os dados que serao inseridos nos campos
    @Override
    public void onBindViewHolder(AcaoViewHolder  holder, int position) {
        holder.nomeAcao.setText(acoes.get(position).getNome());
        holder.nomeAcao.setText(acoes.get(position).getDescricao());
        //holder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return acoes.size();
    }


    //aqui tu inicializa e instacia as coisas (dados da tela)
    public static class AcaoViewHolder extends RecyclerView.ViewHolder {
        CardView cardViewAcao;
        TextView nomeAcao;
        TextView descricaoAcao;
        //ImageView personPhoto;

        AcaoViewHolder (View itemView) {
            super(itemView);
            cardViewAcao = (CardView)itemView.findViewById(R.id.cv_evento);
            nomeAcao = (TextView)itemView.findViewById(R.id.person_name);
            descricaoAcao = (TextView)itemView.findViewById(R.id.person_age);
            //personPhoto = (ImageView)itemView.findViewById(R.id.tv_dado_categoria_evento);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}