import { useEffect, useState } from 'react'
import { buscarStatus } from './api/status'

type EstadoApi = 'verificando' | 'online' | 'offline'

function App() {
  const [api, setApi] = useState<EstadoApi>('verificando')

  useEffect(() => {
    const controle = new AbortController()
    buscarStatus(controle.signal)
      .then(() => setApi('online'))
      .catch((erro: unknown) => {
        if (!controle.signal.aborted) {
          console.error(erro)
          setApi('offline')
        }
      })
    return () => controle.abort()
  }, [])

  const rotulo = {
    verificando: 'Verificando a API…',
    online: 'API online',
    offline: 'API fora do ar',
  }[api]

  const cor = {
    verificando: 'bg-white/40',
    online: 'bg-emerald-400',
    offline: 'bg-red-400',
  }[api]

  return (
    <main className="flex min-h-dvh flex-col items-center justify-center gap-6 bg-marca px-4 text-center text-white">
      <h1 className="text-4xl font-bold tracking-tight">
        Guide<span className="text-destaque">.app</span>
      </h1>
      <p className="max-w-sm text-lg text-white/80">
        Rolês na sua cidade com pessoas que combinam com você.
      </p>
      <p className="flex items-center gap-2 rounded-full bg-white/10 px-4 py-2 text-sm" role="status">
        <span className={`size-2.5 rounded-full ${cor}`} aria-hidden="true" />
        {rotulo}
      </p>
    </main>
  )
}

export default App
