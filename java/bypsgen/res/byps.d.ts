// noinspection JSUnusedGlobalSymbols

declare namespace byps {
	export type long = `${number}.` | number;
	/**
	 * Optional: function to create a HTML5 compatible Promise.
	 * If this member is set, all function calls are executed asynchronously and
	 * return a Promise object.
	 * Example: function(cb) { return new Promise(cb); }
	 * The created Promise object must supply the callback function cb with two parameters:
	 * a resolve function and a reject function.
	 */
	let createPromise: <T>(callback: () => T) => Promise<T>;

	/**
	 * Initialize default asynchronous processing.
	 * After this function has been called, all byps functions are processed asynchronously and return a Promise
	 * object. If the JavaScript environment does not provide a Promise "class", include a jQuery library that supports
	 * $.Deferred (tested with jquery 2.1.).
	 */
	function initPromiseDefaultImpl(): typeof createPromise;

	/**
	 * Longpoll timeout.
	 * Usually a timeout of 30s is used in client applications communicating over the internet.
	 * E.g. the default browser on my Android tablet ignores XHR.timeout and always uses 30s.
	 */
	let LONGPOLL_TIMEOUT_SECONDS: number;

	class BBinaryModel<T> {
		public MEDIUM: "MEDIUM";
		public JSON: "JSON";

		private _value: T;

		constructor(value: T);

		equals(rhs: any): boolean;
	}

	namespace BExceptionO {
		function formatMessage(code: number, msg?: string, details?: string, cause?: unknown): string;
	}

	class BException {
		public _typeId: 20;
		public code: number;
		public msg?: string;
		public details?: string;
		public cause?: unknown;

		constructor(code: number, msg?: string, details?: string, cause?: unknown);

		toString(): string;
	}

	function throwExceptionFromStream(data: any): never;

	function throwBException(code: number, msg?: string, details?: string, cause?: unknown): never;

	function throwCORRUPT(msg?: string, details?: string): never;

	function throwIOERROR(msg?: string, details?: string): never;

	function throwUNSUPPORTED(msg?: string, details?: string): never;

	function throwINTERNAL(msg?: string, details?: string): never;

	function throwTIMEOUT(msg?: string, details?: string): never;

	enum BExceptionC {
		/**
		 * Connection failed. A connection could not be established or a communication
		 * error occured (SocketException).
		 */
		CONNECTION_TO_SERVER_FAILED = 2,

		/**
		 * Internal error. Error code for unexpected internal error states. This
		 * errors are most likely caused due to a bug in byps.
		 */
		INTERNAL = 3,

		/**
		 * Corrupt stream data. The data to be deserialized is corrupt.
		 */
		CORRUPT = 8,

		/**
		 * Undeclared exception. If an undeclared exception is throw in a remote
		 * interface implementation, the peer receives a BException object with this
		 * code. An exception is undeclared if it is not defined in the API package
		 * and is not BException, e.g. NullPointerException.
		 */
		REMOTE_ERROR = 10,

		/**
		 * Service not implemented. This code is used, if a requested remote interface
		 * does not have an implementation.
		 */
		SERVICE_NOT_IMPLEMENTED = 11,

		/**
		 * Server cannot reach client for reverse request. This code is set in a call
		 * from server to client or from client to client, if the receiver is no more
		 * connected.
		 */
		CLIENT_DIED = 12,

		/**
		 * Communication error. This code is used, if a stream operation fails.
		 */
		IOERROR = 14,

		/**
		 * Too many requests. This code is used on the client side, if the thread pool
		 * for sending requests is exhausted.
		 */
		TOO_MANY_REQUESTS = 15,

		/**
		 * This code is used on the client size, if the BTransportFactory object does
		 * not support reverse connections.
		 */
		NO_REVERSE_CONNECTIONS = 16,

		/**
		 * This code is used, if a remote interface implementation does not support
		 * the requested method.
		 */
		UNSUPPORTED_METHOD = 17,

		/**
		 * Operation cancelled. This code is used, if an operation was cancelled or
		 * interrupted.
		 */
		CANCELLED = 19,

		/**
		 * Reverse HTTP request should be sent again.
		 * After HConstants#TIMEOUT_LONGPOLL_MILLIS, the server releases
		 * a long-poll (reverse) request. The client should open
		 * a new long-poll. The server sends an empty response to the client.
		 */
		RESEND_LONG_POLL = 204,

		/**
		 * This code can be used, if authentication is required for the method. Same
		 * as HttpURLConnection.HTTP_UNAUTHORIZED.
		 */
		UNAUTHORIZED = 401,

		/**
		 * This code can be used, if authentication has failed.
		 * Same as HttpURLConnection.HTTP_FORBIDDEN.
		 */
		FORBIDDEN = 403,

		/**
		 * Timeout. This code is used, if an operation exceeds its time limit.
		 * HWireClientR sends this code for expired long-polls. Same value as
		 * HttpURLConnection.HTTP_CLIENT_TIMEOUT.
		 */
		TIMEOUT = 408,

		/**
		 * Client has already invalidated the session. Same value as
		 * HttpURLConnection.HTTP_GONE.
		 */
		SESSION_CLOSED = 410,
	}

	class BContentStream {
		public _typeId: 15;
		public streamId: unknown;

		constructor(streamId: unknown);
	}

	class BSerializer {
		public inlineInstance: unknown;

		constructor(persistentNames: unknown, inlineNames: unknown, inlineInstance: unknown);

		write(obj: unknown, bout: unknown): void;

		read(obj: unknown, bin: unknown): void;
	}

	class BSerializerArray {
		constructor(elementTypeId: number, nbOfDimensions: number);

		write(obj: unknown, bout: unknown): void;

		read(obj: unknown, bin: unknown): void;
	}

	class BSerializerMap {
		constructor(valueTypeId: number);

		write(obj: unknown, bout: unknown): void;

		read(obj: unknown, bin: unknown): void;
	}

	class BSerializer_15 extends BSerializer {
		constructor();
	}

	class BSerializer_17 extends BSerializer {
		constructor();
	}

	class BSerializer_16 {
		constructor(clazz: unknown);

		write(obj: unknown, bout: unknown): void;

		read(obj: unknown, bin: unknown): void;
	}

	class BRegistry {
		private _defaultSerializer: BSerializer;
		private _streamSerializer: BSerializer;
		private _dateSerializer: BSerializer;

		constructor();

		getSerializer(typeId: number): BSerializer;
	}

	/**
	 * This class describes a generated API.
	 * The member values are taken from the BApi class that has to be defined
	 * in one of the packages of the API.
	 * The BApi class defines the interface name and the interface version.
	 * The generator creates a class named BApiDescriptor_name which
	 * holds a singleton object of type BApiDescriptor.
	 */
	class BApiDescriptor {
		/**
		 * API name.
		 * This name is used as a suffix for several generated classes,
		 * BClient_name, BServer_name, BApiDescriptor_name.
		 *
		 */
		public name: string;

		/**
		 * Base package.
		 * The classes generated to serialize arrays and collection types
		 * are members of this package.
		 */
		public basePackage: string;

		/**
		 * API interface version.
		 */
		public version: long;

		/**
		 * Reserved.
		 */
		public uniqueObjects: boolean;
		public protocols: string;
		public registry: BRegistry;

		constructor(
			name?: string,
			basePackage?: string,
			version?: long,
			uniqueObjects?: boolean,
			protocols?: string,
			registry?: byps.BRegistry,
		);
	}

	class BTargetId {
		public serverId: number;
		public remoteId: number;
		public v1: long;
		public v2: long;
		public signature: long;

		constructor(version?: string);

		getStreamId(): long;

		getMessageId(): long;

		getRemoteId(): number;

		toString(): string;
	}

	class BNegotiate {
		public JSON: "J";
		public protocols: "J";
		public version: long;
		public targetId: BTargetId;
		public sessionId: string;
		public bversion: BMessageHeaderC.BYPS_VERSION_WITH_SESSIONID;

		constructor(apiDesc: BApiDescriptor);

		toArray(): unknown[];

		fromArray(arr: unknown[]): void;
	}

	function BNegotiate_isNegotiateMessage(buf: string): boolean;

	class BStreamRequest {
		public streamId: string;
		public messageId: string;
		public downloadUrl: string;
		public uploadResult: string;
	}

	class BMessage {
		public jsonText: string;
		public streams: BStreamRequest[];

		constructor(jsonText: string, streams: BStreamRequest[]);
	}

	class BMessageHeader {
		public error: number;
		public flags: number;
		public targetId: BTargetId | null;
		public messageId: long | "";
		public sessionId: long | "";

		constructor(messageId_or_rhs: string | BMessageHeader);

		createResponse(rhs?: unknown): BMessageHeader;
	}

	enum BMessageHeaderC {
		FLAG_RESPONSE = 2,
		FLAG_LONGPOLL = 2,
		FLAG_TIMEOUT = 4,
		FLAG_LONGPOLL_TIMEOUT = 6,
		BYPS_VERSION_WITH_SESSIONID = 3,
	}

	type BAsyncResult<T> = (result: T | null, error: Error | null | undefined) => void;

	class BWireClient {
		public flags: number;
		public targetId: BTargetId;
		public timeoutMillisClient: number;
		public openRequestsToCancel: Record<number, XMLHttpRequest>;
		public clientUtilityRequests: ureq.BStub_BUtilityRequests | null;
		private _url: string;

		constructor(url: string, flags: number, timeoutSeconds: number);

		/**
		 * Send bytes in buf and receive result in asyncResult.
		 * Override this function to implement a useful transport of bytes.
		 * This function is only used on the client side.
		 */
		send(requestMessage: BMessage, asyncResult: BAsyncResult<unknown>, processAsync: boolean): void;

		/**
		 * Send message with infinite read timeout.
		 */
		sendR(requestMessage: BMessage, asyncResult: BAsyncResult<unknown>): void;

		/**
		 * Returns a unique message ID.
		 *
		 * @returns message ID
		 */
		makeMessageId(): string;

		/**
		 * Kill all requests and free resources.
		 */
		done(asyncResult: BAsyncResult<unknown>): void;

		cancelAllRequests(asyncResult: BAsyncResult<unknown>): void;

		getServletPathForNegotiationAndAuthentication(): string;

		getServletPathForReverseRequest(): string;

		getUrlStringBuilder(servletPath: string): string;

		setSessionForUtilityRequests(responseText: string): void;

		private _internalSend(
			requestMessage: BMessage,
			asyncResult: BAsyncResult<unknown>,
			isReverse: boolean,
			processAsync: boolean,
		): void;

		private _internalCancelAllRequests(cancelMessageId: string, asyncResult: BAsyncResult<unknown>): void;

		private _sendCancelMessage(cancelMessageId: string, asyncResult: BAsyncResult<unknown>): void;
	}

	interface Remote {
		_typeId: number;
		apiDesc: BApiDescriptor;
		wire: BWireClient;
		transport: BTransport;
	}

	interface BAuthentication {
		/**
		 * Authenticate the current user.
		 *
		 * @param client
		 *		  BClient object
		 * @param asyncResult
		 *		  Result object, only the exception is evaluated.
		 */
		authenticate(client: BWireClient, asyncResult: BAsyncResult<unknown>): boolean;

		/**
		 * Return true, if the given exception has to trigger authentication.
		 *
		 * @param client
		 *		  BClient object
		 * @param ex
		 *		  Exception returned from the last request.
		 * @param typeId
		 *		  Type ID (serialVersionUID) of the last request class. For each API function,
		 *		  the generator has created a request class named BRequest_functionname.
		 *		  The passed type ID is the serialVersionUID of this class.
		 * @returns true triggers authentication, false forwards the exception to the
		 *		 caller.
		 */
		isReloginException(client: BWireClient, ex: BException, typeId: number): boolean;

		/**
		 * Return the object representing the current session.
		 * This object will be passed to every request class (e.g. BRequest_functionname)
		 * for remote interfaces tagged with @BSessionParamType.
		 * If the function throws an exception, the isReloginException and maybe the authentication
		 * functions are called before the current method request is sent.
		 *
		 * @param client
		 *		  BClient object
		 * @param typeId
		 *		  Type ID (serialVersionUID) of the last request class, see {@link #isReloginException(BClient, Throwable, int)}.
		 * @param asyncResult
		 *		  This object receives the session object or an exception.
		 * @see BMethodRequest#setSession(Object)
		 */
		getSession(client: BWireClient, typeId: number, asyncResult: BAsyncResult<unknown>): unknown;
	}

	class BTransport {
		public apiDesc: BApiDescriptor;
		public wire: BWireClient;
		public connectedToServerId?: number;
		public sessionId?: string;

		private _authentication: BAuthentication;

		constructor(apiDesc: BApiDescriptor, wire: BWireClient, targetId: BTargetId);

		setTargetId(targetId: BTargetId): void;

		getTargetId(): BTargetId;

		setSessionId(sessionId: string): void;

		getSessionId(): string;

		getOutput(): BInputOutput;

		getResponse(requestHeader: BMessageHeader): BInputOutput;

		getInput(jsonText: string): BInputOutput;

		sendMethod(methodRequest: unknown): Promise<unknown>;
		sendMethod(methodRequest: unknown, asyncResult: BAsyncResult<unknown>): void;

		send(obj: unknown, asyncResult: BAsyncResult<unknown>, processAsync: boolean): void;

		recv(server: BServer, requestMessage: BMessage, asyncResult: BAsyncResult<unknown>): void;

		negotiateProtocolClient(asyncResult: BAsyncResult<unknown>, processAsync: boolean): true;

		createServerR(server: BServer): BServerR;

		setAuthentication(auth: BAuthentication): void;

		hasAuthentication(): boolean;

		private _internalSendMethod(
			methodRequest: unknown,
			asyncResult: BAsyncResult<unknown>,
			processAsync?: boolean,
		): Promise<unknown> | void;

		private _assignSessionThenSendMethod(
			methodRequest: unknown,
			asyncResult: BAsyncResult<unknown>,
			processAsync: boolean,
		): void;

		private _assignSessionInMethodRequest(methodRequest: unknown, session: unknown): void;

		private _internalSend(obj: unknown, asyncResult: BAsyncResult<unknown>, processAsync: boolean): void;

		private _internalAuthenticate(asyncResult: BAsyncResult<unknown>, processAsync: boolean);

		private _internalIsReloginException(ex: BException, typeId: number);

		private _reloginAndRetrySend(methodRequest: unknown, asyncResult: BAsyncResult<unknown>, processAsync: boolean);
	}

	function createTransportForRemote(transport: Remote, targetId: BTargetId): BTransport;

	class BInputOutput {
		public transport: BTransport;
		public registry: BRegistry;
		public header: BMessageHeader;

		private _objectTable: Record<number, unknown>;
		private _root: unknown | null;
		private _jsonText: string;
		private _restoreInfos: Array<[unknown, unknown, string]>;

		constructor(transport: any, header: any, jsonText: any);

		store(root: unknown): BMessage;

		setException(ex: BException): void;

		load(): unknown;

		toMessage(): BMessage;

		writeElement(obj: unknown, ename: string, ser: BSerializer): void;

		readElement(obj: unknown, ename: string, ser: BSerializer): void;

		saveTransient(obj: unknown, ename: string): void;

		private _internalStore(): void;

		private _internalLoad(): void;

		private _restoreTransients(): void;

		private _removeIds(): void;
	}

	abstract class BClient {
		public abstract transport: BTransport;
		protected abstract _serverR: BServerR;
		/**
		 * Start reverse server.
		 */
		private _startRVal: boolean;

		start(asyncResultOrStartR: BAsyncResult<BClient>, startROrNothing?: boolean): void;
		start(asyncResultOrStartR: boolean): Promise<BClient>;
		start(asyncResultOrStartR?: null, startROrNothing?: boolean): Promise<BClient>;

		startR(): void;

		done(): Promise<unknown>;

		done(asyncResult: BAsyncResult<unknown>): void;

		addRemote(remoteImpl: Remote): void;

		getAuthentication(): BAuthentication;

		setAuthentication(innerAuth: BAuthentication): void;

		private _internalStart(asyncResult: BAsyncResult<BClient>, startR: boolean): void;

		private _internalDone(asyncResult: BAsyncResult<unknown>): void;

		private _internalStartR(): void;
	}

	class BClient_subclass extends BClient {
		public transport: BTransport;
		protected _serverR: BServerR;

		constructor(transport: BTransport, serverR: BServerR);
	}

	class BTransportFactory {
		private _nbOfServerRConns: number;
		private _transport: BTransport;

		constructor(apiDesc: BApiDescriptor, wire: BWireClient, nbOfServerRConns: number);

		createClientTransport(): BTransport;

		createServerTransport(): BTransport;

		createClientR(client: BClient): null;

		createServerR(server: BServer): BServerR;
	}

	abstract class BServer {
		public abstract transport: BTransport;
		protected abstract _remotes: Record<string, Remote>;
		protected abstract _methodMap: Record<number, [number, number, unknown]>;

		addRemote(remoteId: string, remoteImpl: Remote): void;

		recv(clientTargetId: undefined, methodObj: unknown, methodResultObj: BAsyncResult<unknown>): void;
	}

	class BServerR {
		public transport: BTransport;
		public server: BServer;
		private _isDone: boolean;

		constructor(transport: any, server: any);

		start(): void;

		private _run(methodResult: BMessage): void;

		private _makeInitMessage(): BMessage;
	}

	namespace ureq {
		const BApiDescriptor_BUtilityRequests: {
			VERSION: string;
			instance(): BApiDescriptor;
		};

		/**
		 * ----------------------------------------------
		 * Client class
		 * ----------------------------------------------
		 *
		 * @param transportFactory
		 */
		function createClient_BUtilityRequests(transportFactory: BTransportFactory): BClient_BUtilityRequests;

		class BClient_BUtilityRequests extends BClient {
			public transport: BTransport;
			public bUtilityRequests: BStub_BUtilityRequests;
			protected _serverR: BServerR;

			constructor(transportFactory: BTransportFactory);
		}

		class BStub_BUtilityRequests {
			public _typeId: number;
			public transport: BTransport;

			constructor(transport: BTransport);

			cancelMessage(messageId: string): Promise<unknown>;
			cancelMessage(messageId: string, __byps__asyncResult: BAsyncResult<unknown>): void;

			testAdapter(functionName: string, params: unknown): Promise<unknown>;
			testAdapter(functionName: string, params: unknown, __byps__asyncResult: BAsyncResult<unknown>): void;

			execute(functionName: string, params: unknown): Promise<unknown>;
			execute(functionName: string, params: unknown, __byps__asyncResult: BAsyncResult<unknown>): void;
		}

		/**
		 * ----------------------------------------------
		 * Server class
		 * ----------------------------------------------
		 */
		class BServer_BUtilityRequests extends BServer {
			public transport: BTransport;
			protected _remotes: Record<string, Remote>;
			protected _methodMap: Record<number, [number, number, unknown]>;
		}

		/**
		 * ----------------------------------------------
		 * Registry
		 * ----------------------------------------------
		 */
		class BRegistry_BUtilityRequests extends BRegistry {}
	}
}
