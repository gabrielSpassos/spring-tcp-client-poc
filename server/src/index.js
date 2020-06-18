const net = require('net');
const port = 5000;
const server = new net.Server();

server.listen(port, () => {
    console.log(`Server listening for connection requests on socket localhost:${port}`);
});

server.on('connection', (socket) => {
    console.log('A new connection has been established.');

    socket.on('data', (chunk) => {
        console.log(`Data received from client: ${chunk.toString()}`);
        socket.write('Successfully received');
    });

    socket.on('end', function() {
        console.log('Closing connection with the client');
    });

    socket.on('error', function(err) {
        console.log(`Error: ${err}`);
    });
});