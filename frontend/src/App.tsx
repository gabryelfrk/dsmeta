import Header from "./components/Header";
import CartaoDeVendas from "./components/CartaoDeVendas";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
    <>
      <ToastContainer />
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <CartaoDeVendas />
          </div>
        </section>
      </main>
    </>

  )
}

export default App;
