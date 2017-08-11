require 'net/http'
require 'uri'

def load_message(fixture_file)
  result = ModavCucumber.load_fixture("#{fixture_file}.json")
  JSON.parse(result)
end

def restclient_connect(url)
  myResource = RestClient::Resource.new(url)
  result = myResource.get
  @responseJSON = JSON.parse(result.body)
end

# Examples start

When(/^url called$/) do
  restclient_connect('https://localhost:8443/hello')
end

Then(/^Lambda will respond with a JSON like (.*)$/) do |fixture_name|
  @expected_result = load_message(fixture_name)
  puts @responseJSON[0]['user']['description']
  puts @expected_result['user']['description']
  expect(@responseJSON[0]['user']['description']).to eq(@expected_result['user']['description'])
end


Given(/^twitter responses with json when url called$/) do
  # path = "statuses/user_timeline.json?screen_name=FreeHackney&include_my_retweet=true&count=2&page=1&include_entities=true"
  path = "hello"
  mockedTwitter = MockedTwitter.new("Twitter1")
  @mock_twitter = mockedTwitter.mock_twitter(path)
end

# Examples start




Given(/^blockchain bootstraps$/) do
  pending
  # show which ports are running for what
end

When(/^url "(.*)" called$/) do |url|
  pending
  @response=restclient_connect('http://localhost:3001/#{url}')
end

Then(/^genesis block created$/) do
  pending
  expect(@response).to eq("{genisi block}")
end

And(/^broadcast to all blockchains$/) do
  pending
end

Given(/^that blockchain exists$/) do
  pending
end

And(/^new blockchain data$/) do
  pending
end

When(/^data posted to url "\/mines"$/) do |arg|
  pending
end

Then(/^latest created block broadcast$/) do
  pending
end

Given(/^other peers with blockchains exist$/) do
  pending
end

When(/^url "\/peers" called$/) do |arg|
  pending
end

Then(/^responds with addresses of remote peers$/) do
  pending
end

Given(/^that a peer is ready$/) do
  pending
end

When(/^a request to connect is received$/) do
  pending
end

Then(/^peer should connect with that peer$/) do
  pending
end