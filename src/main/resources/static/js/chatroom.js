var stompClient = null;

function setConnected(connected) {
  $("#connect").prop("disabled", connected);
  $("#disconnect").prop("disabled", !connected);
  if (connected) {
    $("#conversation").show();
  } else {
    $("#conversation").hide();
  }
  $("#chat-messages").html("");
}

function connect() {
  var socket = new SockJS('/chat-socket');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/chatreceiver', function (greeting) {
      showGreeting(JSON.parse(greeting.body).content, 'Lederer');
    });
  });
}

function disconnect() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  setConnected(false);
  console.log("Disconnected");
}

function sendName() {
  stompClient.send("/app/chatsender", {}, JSON.stringify({'name': $("#text-input").val()}));
}

function showGreeting(message, name) {
  $("#chat-messages").append("" +
    "<div class=\"chatroom-content\">" +
    "<div class=\"userinfo\">" +
    "<img src=\"../images/profile.png\">" +
    "<p>" + name + "</p>" +
    "</div>" +
    "<div class=\"usertext\">" +
    "<p>" + message + "</p>" +
    "</div>" +
    "<hr></div>");
}

$(function () {
  $("form").on('submit', function (e) {
    e.preventDefault();
  });
  $("#connect").click(function () {
    connect();
  });
  $("#disconnect").click(function () {
    disconnect();
  });
  $("#send").click(function () {
    sendName();
  });
});
