import Header from "./components/Header";
import CartaoDeVendas from "./components/CartaoDeVendas";

function App() {
  return (
    <>
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
