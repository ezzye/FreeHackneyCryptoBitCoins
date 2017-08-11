require 'ap'
require 'mod_av_cucumber_env'
require 'mod_av_cucumber/fixtures'
require 'aws-sdk'
require 'rest-client'
require 'rest-assured'

AfterConfiguration do

  # set server and p2p port constants
  HTTP_PORT=3001
  P2P_PORT=6001

  ModavCucumber.setup_and_start_under_test(
      create_cached_server
  )
end

def create_cached_server()
  create_server([
                    File.expand_path('../../../../../run', __FILE__),
                    "--http_port", HTTP_PORT,
                    "--http_port", P2P_PORT
                ],
                true)
end
