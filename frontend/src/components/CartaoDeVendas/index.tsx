import BotaoDeNotificacao from '../BotaoDeNotificacao';
import './styles.css';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useEffect, useState } from 'react';
import axios from 'axios';
import { BASE_URL } from '../../utils/request';
import { Venda } from '../../models/Venda';

function CartaoDeVendas() {

  const min = new Date(new Date().setDate(new Date().getDate() - 365));
  const max = new Date();

  const [dataMin, setDataMin] = useState(min);
  const [dataMax, setDataMax] = useState(max);

  const [vendas, setVendas] = useState<Venda[]>([]);

  const dmin = dataMin.toISOString().slice(0, 10);
  const dmax = dataMax.toISOString().slice(0, 10);

  useEffect(() => {
    axios.get(`${BASE_URL}/vendas?dataMin=${dmin}&dataMax=${dmax}`)
      .then(response => { // Promise
        setVendas(response.data.content);
      })
  }, [dataMin, dataMax]);

  return (
    <div className="dsmeta-card">
      <h2 className="dsmeta-sales-title">Vendas</h2>
      <div>
        <div className="dsmeta-form-control-container">
          <DatePicker
            selected={dataMin}
            onChange={(date: Date) => setDataMin(date)}
            className="dsmeta-form-control"
            dateFormat="dd/MM/yyyy"
          />
        </div>
        <div className="dsmeta-form-control-container">
          <DatePicker
            selected={dataMax}
            onChange={(date: Date) => setDataMax(date)}
            className="dsmeta-form-control"
            dateFormat="dd/MM/yyyy"
          />
        </div>
      </div>
      <div>
        <table className="dsmeta-sales-table">
          <thead>
            <tr>
              <th className="show992">ID</th>
              <th className="show576">Data</th>
              <th>Vendedor</th>
              <th className="show992">Visitas</th>
              <th className="show992">Vendas</th>
              <th>Total</th>
              <th>Notificar</th>
            </tr>
          </thead>
          <tbody>
            {vendas.map(venda => {
              return (
                <tr key={venda.id}>
                  <td className="show992">{venda.id}</td>
                  <td className="show576">{new Date(venda.data).toLocaleDateString()}</td>
                  <td>{venda.nomeVendedor}</td>
                  <td className="show992">{venda.visitas}</td>
                  <td className="show992">{venda.vendas}</td>
                  <td>R$ {venda.total.toFixed(2)}</td>
                  <td>
                    <div className="dsmeta-red-btn-container">
                      <BotaoDeNotificacao />
                    </div>
                  </td>
                </tr>
              )
            })
            }
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default CartaoDeVendas;
