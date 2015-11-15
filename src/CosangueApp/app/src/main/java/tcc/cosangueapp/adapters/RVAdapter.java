package tcc.cosangueapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tcc.cosangueapp.R;
import tcc.cosangueapp.activities.DetalhesEventos;
import tcc.cosangueapp.pojos.Acao;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.AcaoViewHolder> {


    static List<Acao> acoes;
    private static Context context;


    public RVAdapter(List<Acao> acoes, Context context) {
        this.acoes = acoes;
        this.context = context;
    }


    // AQUI VAI O LAYOUT DE CADA ITEM DO RECYCLER VIEW
    @Override
    public AcaoViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_view, viewGroup, false);
        AcaoViewHolder avh = new AcaoViewHolder(v);
        return avh;
    }


    //aqui tu seta  todos os dados que serao inseridos nos campos
    @Override
    public void onBindViewHolder(AcaoViewHolder holder, int position) {
        holder.nomeAcao.setText(acoes.get(position).getNome());
        holder.descricaoAcao.setText(acoes.get(position).getDescricao());
        //holder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return acoes.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    //aqui tu inicializa e instacia as coisas (dados da tela)
    public class AcaoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cardViewAcao;
        TextView nomeAcao;
        TextView descricaoAcao;
        //ImageView personPhoto;


        AcaoViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
            cardViewAcao = (CardView) itemView.findViewById(R.id.cv_evento);
            nomeAcao = (TextView) itemView.findViewById(R.id.nome_acao);
            descricaoAcao = (TextView) itemView.findViewById(R.id.descricao_acao);
            //personPhoto = (ImageView)itemView.findViewById(R.id.tv_dado_categoria_evento);

        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Log.d("TAG", "onClick " + position + " " + itemView);
            Intent intent = new Intent(context, DetalhesEventos.class);
            intent.putExtra("acao", acoes.get(position));
            context.startActivity(intent);
        }
    }
}
