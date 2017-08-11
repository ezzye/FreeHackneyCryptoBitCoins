# Created by ellioe03 at 01/08/2017
Feature: #Simple Blockchain Http Server
  # Simple crypto currency
  #  HTTP interface to control the node
  #  Use Websockets to communicate with other nodes (P2P)
  #  Super simple "protocols" in P2P communication
  #  Data is not persisted in nodes
  #  No proof-of-work or proof-of-stake: a block can be added to the blockchain without competition

  Scenario: First block request creates genesis block
    Given blockchain bootstraps
    and another blockchain created
    When url "/blocks" called
    Then genesis block created
    And broadcast to another blockchains


  # See other functions

  Scenario: Mine a block to add new data to blockchain
    Given that blockchain exists
    And new blockchain data
    When data posted to url "/mines"
    Then latest created block broadcast

  Scenario: Find other peers with blockchains
    Given other peers with blockchains exist
    When url "/peers" called
    Then responds with addresses of remote peers

   Scenario: Connect to new peer
     Given that a peer is ready
     When a request to connect is received
     Then peer should connect with that peer



