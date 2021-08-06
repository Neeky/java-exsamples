#!/usr/bin/evn python3

import logging
import argparse
from concurrent import futures

from helloworld_pb2 import HelloRequest,HelloReply
from helloworld_pb2_grpc import GreeterStub

import grpc


with grpc.insecure_channel(f"127.0.0.1:10352") as channel:
    stub = GreeterStub(channel)
    reply = stub.SayHello(HelloRequest(name="dalio"))
    print(reply.message)
