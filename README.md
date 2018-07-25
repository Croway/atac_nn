# atac_nn
implementazione di una rete neurale per stimare il tempo di attesa di autobus

ogni minuto vengono recuperati i dati da due datasource:
http://viaggiacon.atac.roma.it
http://muovi.roma.it
i quali vengono normalizzati, salvati su un database h2 e utilizzati per allenare una rete neurale
