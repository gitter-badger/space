import { Injectable } from '@angular/core';
import { WebSocketService } from '../shared/services/websocket.service';
import { Subject } from 'rxjs';
import { WebSocketEvent } from '../domain/WebSocketEvent';

/**
 * Service for accessing the space-server debug webSocket-API
 */
@Injectable()
export class SpaceDebugWsService {
  public messages: Subject<WebSocketEvent>;

  constructor(private webSocketService: WebSocketService) {
    let wsUrl = SPACE_WS_API_BASEURL;

    if (wsUrl == null || (!wsUrl.startsWith("ws://") && !wsUrl.startsWith("wss://"))) {
      // build absolute url from relative path
      wsUrl = this.getBaseUrl() + SPACE_WS_API_BASEURL;
    }
    console.debug("connecting to space websocket api: " + wsUrl);

    this.messages = <Subject<WebSocketEvent>> webSocketService
      .connect(wsUrl)
      .map((response: MessageEvent): WebSocketEvent => {
        console.log('received ws data: ' + response.data);
        return JSON.parse(response.data);
      });
  }

  private getBaseUrl() {
    let protocol = window.location.protocol === 'https:' ? 'wss://' : 'ws://';
    let host = window.location.hostname;
    let port = ':' + window.location.port;

    return protocol + host + port;
  }

}
