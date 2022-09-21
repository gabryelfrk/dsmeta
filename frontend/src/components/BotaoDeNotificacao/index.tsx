import axios from 'axios';
import { toast } from 'react-toastify';
import icone from '../../assets/img/icone-notificacao.svg';
import { BASE_URL } from '../../utils/request';
import './styles.css';

type Props = {
    vendaId: number;
}

function handleClick(id: number) {
    axios(`${BASE_URL}/vendas/${id}/notificacao`)
        .then(response => {
            toast.info("SMS enviado com sucesso");
        });
}

function BotaoDeNotificacao({ vendaId }: Props) {
    return (

        <div className="dsmeta-red-btn" onClick={() => handleClick(vendaId)}>
            <img src={icone} alt="Notificar" />
        </div>
    )
}

export default BotaoDeNotificacao;
