import icone from '../../assets/img/icone-notificacao.svg'
import './styles.css'

function BotaoDeNotificacao() {
    return (

        <div className="dsmeta-red-btn">
            <img src={icone} alt="Notificar" />
        </div>
    )
}

export default BotaoDeNotificacao
