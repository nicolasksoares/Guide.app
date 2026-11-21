export type StatusApi = {
  aplicacao: string
  status: string
}

/** Consulta GET /api/status (o Vite encaminha /api para o back-end). */
export async function buscarStatus(signal?: AbortSignal): Promise<StatusApi> {
  const resposta = await fetch('/api/status', { signal })
  if (!resposta.ok) {
    throw new Error(`API respondeu ${resposta.status}`)
  }
  return resposta.json() as Promise<StatusApi>
}
